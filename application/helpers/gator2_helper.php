<?php

if (!defined('BASEPATH'))
    exit('No direct script access allowed');

if (!function_exists('get_categories')) {

    function get_categories() {
        $ci = get_instance();
        $ci->load->model('categories_model');

        return $ci->categories_model->get_categories();
    }

}


if (!function_exists('categories_select')) {

    function categories_select($top_option, $properties = '', $selected = 0) {
        $categories = get_categories();

        echo "<select $properties>\n";
        echo "<option value='0'>$top_option</option>\n";
        foreach ($categories as $category) {
            $x = $selected == $category['id'] ? "selected" : "";
            echo "<option $x value='{$category['id']}'>{$category['category']}</option>\n";
        }
    }

}

if (!function_exists('gs_pagination')) {

    function gs_pagination($total, $uri, $get = '', $cur_page = 0, $items_per_page = 10) {
        if($total==0){$total = 1;}
        $num_pages = intdiv($total -1, $items_per_page) + 1;
        $page_group = intdiv($cur_page, 5);
        $num_groups = intdiv($num_pages - 1, 5) + 1;
        $page = intdiv($cur_page, $items_per_page) * $items_per_page - 1;
        $link_previous_group = site_url($uri) . "/$page?$get" ;
        $link_next_group = site_url($uri) . '/' . (intdiv($cur_page, $items_per_page)+1) * $items_per_page . "?$get";
        $head = $page_group == 0 ? '' : "<li><a href='$link_previous_group'>&laquo;</a></li>";
        $tail = $page_group == $num_groups -1 ? '' : "<li><a href='$link_next_group'>&raquo;</a></li>";
        $body = '';
        for($page_num = $page_group * 5;($page_num < ($page_group + 1)*5) && ($page_num < $num_pages);$page_num++){
            $active = $page_num == $cur_page ? 'class="active"' : '';
            $disp_page = $page_num + 1;
            $link = site_url($uri) . "/$page_num?$get";
            $body = $body . "<li $active><a href='$link'>$disp_page</a></li>";
        }
        
        echo '<nav class="pull-right"><ul class="pagination">';
        echo $head . $body . $tail;
        echo '</ul></nav>';
    }

}
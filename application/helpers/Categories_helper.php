<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

if ( ! function_exists('get_categories')){
   function get_categories(){
       $ci = get_instance();
       $ci->load->model('categories_model');
       
       return $ci->categories_model->get_categories();
   }
}


if ( ! function_exists('categories_select')){
   function categories_select($top_option, $properties = '', $selected = 0){
       $categories = get_categories();
      
       echo "<select $properties>\n";
       echo "<option value='0'>$top_option</option>\n";
       foreach ($categories as $category){
           $x = $selected == $category['id'] ? "selected" : "";
           echo "<option $x value='{$category['id']}'>{$category['category']}</option>\n";
       }
   }
}
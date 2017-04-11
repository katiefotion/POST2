<?php

class Pages extends CI_Controller {

    public function view($page = 'home') {
        if (!file_exists(APPPATH . 'views/pages/' . $page . '.php')) {
            // Whoops, we don't have a page for that!
            show_404();
        }

        $this->load->model('categories_model');
 
        $data['categories'] = $this->categories_model->get_categories();
        $data['selected'] = 0;
        $data['title'] = 'Items';

        $this->load->view('templates/header', $data);
        $this->load->view('pages/' . $page, $data);
        $this->load->view('templates/footer');
    }

}

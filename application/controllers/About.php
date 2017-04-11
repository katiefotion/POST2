<?php

class About extends CI_Controller {

    public function view($page = 'about') {
        if (!file_exists(APPPATH . 'views/about/' . $page . '.php')) {
            // Whoops, we don't have a page for that!
            show_404();
        }

        $this->load->model('categories_model');

        $data['categories'] = $this->categories_model->get_categories();
        $data['selected'] = 0;
        $data['title'] = ucfirst($page); // Capitalize the first letter

        $this->load->view('templates/header', $data);
        $this->load->view('about/' . $page);
        $this->load->view('templates/footer');
    }

}

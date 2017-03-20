<?php

class Prototype extends CI_Controller {

    public function view($category = 0) {

        // load the models we need
        $this->load->model('categories_model');
        $this->load->model('items_model');

        // prepare the data for the view
        $data['categories'] = $this->categories_model->get_categories();
        $data['items'] = $this->items_model->get_items($category);
        $data['selected'] = $category;

        // let the view do what it does
        $this->load->view('templates/header', array('title' => 'Vertical Prototype'));
        $this->load->view('prototype/prototype', $data);
        $this->load->view('templates/footer');
    }

}

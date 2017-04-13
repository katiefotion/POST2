<?php

class Items extends CI_Controller {

    public function view() {
        $this->load->model('items_model');

        $categoryID = $this->input->get('categoryID');
        if (!is_numeric($categoryID))
            $categoryID = 0;

        $data['items'] = $this->items_model->get_items($categoryID);

        $this->load->view('templates/header', array('title' => 'Items For Sale','selected'=>$categoryID));
        $this->load->view('pages/items', $data);
        $this->load->view('templates/footer');
    }

    public function item($id) {
        // load the model and use its get_item function
        $this->load->model('items_model');
        $this->load->model('categories_model');
        $data['item'] = $this->items_model->get_item($id);

        // was the $id valid?? if not show the "404 page not found" page and stop
        if (!isset($data['item'])) {
            show_404();
        }

        $data['categories'] = $this->categories_model->get_categories();
        $data['selected'] = 0;
        $data['title'] = $data['item']->name;
        
        // since $id was good, display the page
        $this->load->view('templates/header', $data);
        $this->load->view('prototype/item', $data);
        $this->load->view('templates/footer');
    }

}

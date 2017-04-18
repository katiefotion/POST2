<?php

class Items extends CI_Controller {

    public function view($categoryID = 0, $page = 0) {
        $this->load->model('items_model');

        $query = isset($_GET['query']) ? $_GET['query'] : '';
        $data['items'] = $this->items_model->get_items($categoryID,$query,$page);
        $data['total'] = $this->items_model->items_count($categoryID,$query);
        $data['categoryID'] = $categoryID;
        $data['page'] = $page;
        $data['start'] = $data['total'] == 0 ? 0 : $page * 10 + 1;
        $data['end'] = ($page + 1) * 10 > $data['total'] ? $data['total'] : ($page + 1) * 10;
        
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

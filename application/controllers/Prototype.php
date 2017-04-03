<?php

class Prototype extends CI_Controller {

    public function view($category = 0) {

        // load the models we need.  The view is going allow users to by
        // category, so we need to load the categories_model.  It will also
        // show the items that match the selected category, so we need the 
        // items_model loaded
        $this->load->model('categories_model');
        $this->load->model('items_model');

        // prepare the data for the view.  "$data['key'] = value" is a key-value
        // value pair.  the keys, when passed to a view, become variables that
        // are available to the view.
        //
        // Getting data from a model works like this:
        // $result = $this->LOADED_MODEL_NAME->someFunctionProvidedByTheModel();
        $data['categories'] = $this->categories_model->get_categories();
        $data['items'] = $this->items_model->get_items($category);
        $data['selected'] = $category;

        // the view 'header' requries a variable $title to be passed to it.
        // array('key1'=> value1,'key2'=>value2, and so on) is another way
        // to set key-value pairs in an array
        $this->load->view('templates/header', array('title' => 'Vertical Prototype'));
        // the view 'prototype' requres $categories, $items, and $selected to be
        // passed as key-value pairs.  This was done in the previous block of 
        // code.  We can simply pass it as $data
        $this->load->view('prototype/prototype', $data);
        // the view 'footer' does not require any values to be passed, so 
        // we don't pass anything
        $this->load->view('templates/footer');
    }
    
    public function item($id){
        // load the model and use its get_item function
        $this->load->model('items_model');
        $data['item'] = $this->items_model->get_item($id);
        
        // was the $id valid?? if not show the "404 page not found" page and stop
        if (!isset($data['item'])){
            show_404();
        }
            
        // since $id was good, display the page
        $this->load->view('templates/header', array('title' => 'Vertical Prototype Item'));
        $this->load->view('prototype/item', $data);
        $this->load->view('templates/footer');
    }

}

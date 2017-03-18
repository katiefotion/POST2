<?php

class Prototype extends CI_Controller {

    public function index() {
        $this->load->model('categories_model');
        $this->load->model('items_model');

        $data['categories'] = $this->categories_model->get_categories();
        $data['cat']=$this->input->post('category');
        $data['title'] = "vertical prototype"; 
        $data['items'] = $this->items_model->get_items($data['cat']);
 

        $this->load->view('templates/header', $data);
        $this->load->view('prototype/prototype', $data);
        $this->load->view('templates/footer', $data);
    }

    public function view($category) {

        // load the photo indexed by id
        $this->load->model('photos_model');

        $data['title'] = "vertical prototype-query result for: $category"; 

      


        // let the view do what it does - send an image to the client
        $this->load->view('templates/header', $data);
        $this->load->view('prototype/prototype', $data);
        $this->load->view('templates/footer', $data);
    }

}

<?php

class Pages extends CI_Controller {

    public function view($page = 'home') {
        if (!file_exists(APPPATH . 'views/pages/' . $page . '.php')) {
            // Whoops, we don't have a page for that!
            show_404();
        }

        $this->load->view('templates/header', array('title' => ucfirst($page)));
        $this->load->view('pages/' . $page);
        $this->load->view('templates/footer');
    }

}

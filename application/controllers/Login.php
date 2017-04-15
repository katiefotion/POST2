<?php

class Login extends CI_Controller {

    public function log() {
        $session_data = array(
            'username' => 'Ronald'
        );
        
        $this->session->set_userdata($session_data);
        redirect('');
//        $this->load->view('templates/header', array('title' => 'GatorSell.com'));
//        $this->load->view('pages/home');
//        $this->load->view('templates/footer');
    }

    public function logout() {
        $this->session->sess_destroy();
        redirect('');
        $this->load->view('templates/header', array('title' => 'GatorSell.com'));
        $this->load->view('pages/home');
        $this->load->view('templates/footer');
    }

}

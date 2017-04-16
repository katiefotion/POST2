<?php

class Login extends CI_Controller {

    public function sign_in() {
        $this->load->model('registered_user_accounts');
        if (isset($_POST['submit'])) {
            $validate = $this->registered_user_accounts->validate_email_and_password($_POST['email'], $_POST['password']);
            if (isset($validate)) {
                $session_data = array(
                    'account' => $validate
                );
                $this->session->set_userdata($session_data);
                redirect('');
            } else {
                $this->load->view('templates/header', array('title' => 'Login'));
                $this->load->view('pages/Login', array('invalid' => true));
                $this->load->view('templates/footer');
            }
        } else {
            $this->load->view('templates/header', array('title' => 'Login'));
            $this->load->view('pages/Login');
            $this->load->view('templates/footer');
        }
    }

    public
            function logout() {
        $this->session->sess_destroy();
        redirect('');
        $this->load->view('templates/header', array('title' => 'GatorSell.com'));
        $this->load->view('pages/home');
        $this->load->view('templates/footer');
    }

}

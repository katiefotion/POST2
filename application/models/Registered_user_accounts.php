<?php

class Registered_user_accounts extends CI_Model {

    public function __construct() {
        parent::__construct();
        $this->load->database();
    }
    public function validate_email_and_password($email,$password) {
        $result = $this->db->where(array('email' => $email, 'password' => md5($password)))
                ->get('registered_user_accounts')
                ->row_array();
        echo $password;
        return $result;
    }

    public function add_account($name, $screen_name, $password, $email, $phone) {
       
        $data = array(
            'name' => $name,
            'screen_name' => $screen_name,
            'email' => $email,
            'phone' => $phone,
            'password' => md5 ($password),
            'agree_to_terms' => true,
            'activated' => false,
            'banned' => false
        );
        
        $this->db->insert('registered_user_accounts', $data);
    }

}

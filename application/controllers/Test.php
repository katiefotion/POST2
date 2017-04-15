<?php

class Test extends CI_Controller {

    public function view() {
        $this->load->model('registered_user_accounts');
        $this->registered_user_accounts->add_account('Jason','ateam45','mrt','sjackson@gmail.com','1800BADMOFO');
        $r1 = $this->registered_user_accounts->validate_email_and_password('sjackson@gmail.com','mrt');
        $r2 = $this->registered_user_accounts->validate_email_and_password('fakesjackson@gmail.com','fakemrt');
        print_r($r1);
        print_r($r2);
        if(isset($r2)){
            echo '$r2 is set';
        } else {
            echo '$r2 is not set';
        } 
            
            
        
    }

}

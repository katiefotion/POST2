<?php
class Categories_model extends CI_Model {

    public function __construct()
    {
        parent::__construct();
        $this->load->database();
    }

    public function get_categories()
    {
        $query = $this->db->get('categories')->result_array();

        return $query;
    }


}

<?php
class Items_model extends CI_Model {

    public function __construct()
    {
        parent::__construct();
        $this->load->database();
    }

    public function get_items($id)
    {
        return $this->db->get_where('items', array('category_id' => $id))->result();
    }
}

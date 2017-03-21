<?php
class Items_model extends CI_Model {

    public function __construct()
    {
        parent::__construct();
        $this->load->database();
    }

    public function get_items($category_id)
    {
        return $this->db->get_where('items_briefdescription_view', array('category_id' => $category_id))->result();
    }
    
    public function get_item($id)
    {
        return $this->db->get_where('items', array('id'=> $id))->first_row();
    }
}

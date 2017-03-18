<?php
class Photos_model extends CI_Model {

    public function __construct()
    {
        parent::__construct();
        $this->load->database();
    }

    public function get_photo($id)
    {
        $query = $this->db->get_where('photos', array('id' => $id));

        return $row = $query->row();
    }


}

<?php
class Photos extends CI_Controller {

    public function view($id)
    {
        // load the photo indexed by id
        $this->load->model('photos_model');
        $photo_data = $this->photos_model->get_photo($id);
        
        // make sure it exists - otherwise terminate with 404 message
        if ( ! isset($photo_data))
                show_404();
        
        // returned data was good, load data for the view handler
        // TODO: add image type to database and set header accordingly
        $data['header'] = "Content-type: image/$photo_data->content_type";
        $data['photo'] = $photo_data->photo;

        // let the view do what it does - send an image to the client
        $this->load->view('templates/photo', $data);
    }
}

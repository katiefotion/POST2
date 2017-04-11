<div class="container-fluid">
    <h1>Available Items For Sale</h1>
    <div class="row">
 
    </div>

    <?php
    foreach ($items as $item) {
        $this->load->view('widgets/itembox', array('item' => $item));
    }
    ?>
</div>

<h1>Vertical prototype for Team 10</h1>
<?php
$this->load->view('widgets/categoryselect', array('categories' => $categories,'selected'=>$selected));
foreach($items as $item){
    $this->load->view('widgets/itembox', array('item'=>$item));
}
<div class="container-fluid">
    <h1>Vertical prototype for Team 10</h1>
    <div class="row">
        <div class="col-md-6">
            <?php
            // show the categoryselect widget.  That widget expects a full table query result 
            // of the database table 'categories' passed as 'categories' and it expects a default
            // category 'id' to passed as 'seclected'.  if selected is 0, nothing is selected
            $this->load->view('widgets/categoryselect', array('categories' => $categories, 'selected' => $selected));
            ?>
        </div>
        <div class="col-md-6">
            <?php
            $this->load->view('widgets/itemselect');
            ?>
        </div>
    </div>

    <?php
    // display all of the items the controller passed as 'items'.  if the array
    // is empty, this will display nothing
    foreach ($items as $item) {
        // show the itembox widget.  this widget expects a single row from the 
        // table 'items' passed as 'item'
        $this->load->view('widgets/itembox', array('item' => $item));
    }
    ?>
</div>

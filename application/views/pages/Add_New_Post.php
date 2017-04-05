<div class = "container">
    
    
    <div class = "row">
        <div class = "col-md-6">
            <?php
            $this->load->helper('form');
            
            echo"<h1>Add New Post:</h1>";
            echo"Name: \t", form_input('name');
            echo"</br>Price: \t", form_input('price');
            //echo"</br>Category:";
            //$this->load->model('categories_model');
            $this->load->view('widgets/categoryselect');
            echo"</br>Description:", form_textarea('description');
            echo"</br>Picture:", form_upload('photo');
            echo"</br>Other:";
            ?>
        </div>
        <div class = "col-md-6">
            <?php
            echo "<h2><strong>Safe Meeting: </h2>";
            echo "Choose at least 2 options that are convient for you:</br>";
            echo "Options:";
            
            ?>
        </div>
        <div class = "col-md-12">
               <?php
            echo "<h2><strong>TODO: Add CANCEL & ADD buttons</h2>";
            ?>
            <a href="#" class="btn btn-default btn-block btn-default" role="button">Cancel</a>
            <a href="#" class="btn btn-default btn-block btn-wrap" role="button">Add</a>

    </div>
</div>

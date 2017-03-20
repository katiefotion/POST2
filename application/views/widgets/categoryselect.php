
<div class = "panel panel-default">
   <div class = "panel-body">
       <span><label>Choose A Category: </label>
     <select class="form-control" name="category" onchange="window.open( this.options[ this.selectedIndex ].value, '_self')">
         <option value="<?php echo site_url("prototype"); ?>">choose a category</option>
        <?php
        foreach ($categories as $category) {
            $x = $selected == $category->id ? "selected" : "";
            $url = site_url("prototype/$category->id");
            echo "<option $x value='$url'>$category->category</option>\n";
        }
        ?>
     </select></span>
   </div>
</div>
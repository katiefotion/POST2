<?php
$this->load->helper('form');
echo form_open('prototype');
?>    
  <div class="form-group">
    <select class="form-control" name="category" onchange='this.form.submit()'>
        <option>choose a category</option>
    <?php  foreach ($categories as $category) {
        $x = $cat == $category->category ? "selected":"";
        echo "<option $x>$category->category</option>";
        } ?>
    </select>
  </div>
<noscript><button type="submit" class="btn btn-primary">Submit</button></noscript>
</form>
<p><?php echo $cat;?></p>
<?php
$this->load->helper('form');
$this->load->helper('url');
echo form_open('prototype');
?>    
<div class="form-group">
    <select class="form-control" name="category" onchange='this.form.submit()'>
        <option>choose a category</option>
        <?php
        foreach ($categories as $category) {
            $x = $cat == $category->id ? "selected" : "";
            echo "<option $x value='$category->id'>$category->category</option>";
        }
        ?>
    </select>
</div>
<noscript><button type="submit" class="btn btn-primary">Submit</button></noscript>
</form>
<?php foreach($items as $item){
    $path = site_url('dbimg/');
    echo "<hr>";
    echo "<img src='$path$item->photo'>";
    echo "<h1><strong>Item name: </strong>$item->name</h1>";
    echo "<h2><strong>Description </strong></h2><br>";
    echo "<p>$item->description</p>";
}?>

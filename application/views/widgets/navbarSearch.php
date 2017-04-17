<form class="navbar-form navbar-left" method="get" action="<?= site_url('items');?>">
    <div class="form-group">
        <?php categories_select('All','class = "form-control" name="categoryID"',$selected);?>
        <input type="text" name="query" class="form-control" placeholder="Search">
    </div>
    <button type="submit" class="btn btn-default">Search</button>
</form>
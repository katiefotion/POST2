<form id="nbs" class="navbar-form navbar-left" method="get" action="<?= site_url('items')."/$selected";?>">
    <div class="form-group">
        <?php categories_select('All','id="nbs_cat_select" class = "form-control" onchange="chgNBSAction()"',$selected);?>
        <input type="text" name="query" class="form-control" placeholder="Search">
    </div>
    <button type="submit" class="btn btn-default">Search</button>
</form>
<script>
function chgNBSAction(){
    cat = document.getElementById('nbs_cat_select').value
    document.getElementById('nbs').action = "<?= site_url('items');?>/" + cat;
}
</script>
    
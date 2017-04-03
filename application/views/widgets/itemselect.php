<div class="panel">
    <div class="form-inline">
        <div class="form-group">
            <label for="itemid">View an Item by ID (start with 15):</label>
            <input type="text" class="form-control" value="" id="itemIDTextField" >
        </div>
        <button type="button" class="btn btn-default" id="itemIDSubmitButton"
                onclick="window.open('<?= site_url('prototype/item/'); ?>' + document.getElementById('itemIDTextField').value, '_self')">Go</button>
    </div>    
</div>

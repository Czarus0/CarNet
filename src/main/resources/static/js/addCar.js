// We can attach the `fileselect` event to all file inputs on the page
$(document).on('change', ':file', function() {
    var input = $(this),
        numFiles = input.get(0).files ? input.get(0).files.length : 1,
        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
    input.trigger('fileselect', [numFiles, label]);
});

// We can watch for our custom `fileselect` event like this
$(document).ready( function() {
    $(':file').on('fileselect', function(event, numFiles, label) {

        var input = $(this).parents('.input-group').find(':text'),
            log = numFiles > 1 ? numFiles + ' files selected' : label;

        if( input.length ) {
            input.val(log);
        } else {
            if( log ) alert(log);
        }

    });
});

var selectCarDealers = document.getElementById("carDealers");

var deleteDefault = function() {
    if(selectCarDealers.selectedIndex !== 0 && selectCarDealers.options[0].text === "Wybierz salon")
        selectCarDealers.remove(0);

    changeBackground();
};

var checkSelection = function() {
    if(selectCarDealers.selectedIndex !== 0)
        selectCarDealers.remove(0);
};

var changeBackground = function() {
    selectCarDealers.classList.add("correctInputBorder")
}
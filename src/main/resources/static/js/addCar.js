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

$('#inputUsed').on('keypress', function(ev) {
    var keyCode = window.event ? ev.keyCode : ev.which;
    //codes for 0-9
    if (keyCode < 48 || keyCode > 57) {
        //codes for backspace, delete, enter
        if (keyCode != 0 && keyCode != 8 && keyCode != 13 && !ev.ctrlKey) {
            ev.preventDefault();
        }
    }
});

$('#inputPrice').on('keypress', function(ev) {
    var keyCode = window.event ? ev.keyCode : ev.which;
    //codes for 0-9
    if (keyCode < 48 || keyCode > 57) {
        //codes for backspace, delete, enter
        if (keyCode != 0 && keyCode != 8 && keyCode != 13 && !ev.ctrlKey) {
            ev.preventDefault();
        }
    }
});



var deleteDefaultAndChangeBackground = function(inputLabelId, message) {
    var selectionInput = document.getElementById(inputLabelId);

    if(selectionInput.selectedIndex !== 0 && selectionInput.options[0].text === message)
        selectionInput.remove(0);

    changeBackground(inputLabelId);
};

var changeBackground = function(inputLabelId) {
    document.getElementById(inputLabelId).classList.add("correctInputBorder")
};

var checkSelection = function() {
    var allSelectionType = document.getElementsByTagName("select");

    for(i = 0; i < allSelectionType.length; i++) {
        if(allSelectionType[i].selectedIndex !== 0)
            allSelectionType[i].remove(0);
    }
};
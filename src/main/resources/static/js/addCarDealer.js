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
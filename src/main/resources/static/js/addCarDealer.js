$('#inputOpenFrom').on('keypress', function(ev) {
    var keyCode = window.event ? ev.keyCode : ev.which;
    //codes for 0-9
    if (keyCode < 48 || keyCode > 57) {
        //codes for backspace, delete, enter
        if (keyCode != 0 && keyCode != 8 && keyCode != 13 && !ev.ctrlKey) {
            ev.preventDefault();
        }
    }
});

$('#inputOpenTo').on('keypress', function(ev) {
    var keyCode = window.event ? ev.keyCode : ev.which;
    //codes for 0-9
    if (keyCode < 48 || keyCode > 57) {
        //codes for backspace, delete, enter
        if (keyCode != 0 && keyCode != 8 && keyCode != 13 && !ev.ctrlKey) {
            ev.preventDefault();
        }
    }
});

var changeBackground = function(inputLabelId) {
    document.getElementById(inputLabelId).classList.add("correctInputBorder")
};

var checkIfHasPhone = function () {
    var checkBoxPhone = document.getElementById('hasPhoneNumber');
    var phoneNumberInput = document.getElementById('inputPhoneNumber');

    if(!checkBoxPhone.checked)
        phoneNumberInput.value = 'Wprowadź numer telefonu';
    else
        phoneNumberInput.value = '';

    phoneNumberInput.disabled = !checkBoxPhone.checked;
};
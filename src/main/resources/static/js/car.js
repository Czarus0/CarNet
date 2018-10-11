$('#imageFile').bind('change', function () {
    var filename = $("#imageFile").val();
    if (/^\s*$/.test(filename)) {
        $(".file-upload").removeClass('active');
        $("#noFile").text("Nie wybrano pliku");
    }
    else {
        $(".file-upload").addClass('active');
        $("#noFile").text(filename.replace("C:\\fakepath\\", ""));
    }
});


$('#imageFile').on('change', function() {
    var numb = $(this)[0].files[0].size/1024/1024;
    numb = numb.toFixed(2);
    if(numb > 2.5) {
        alert('Plik jest za duży (maksymalnie 2,5MB)');
        document.getElementById('imageFile').value = '';
        document.getElementById('noFile').textContent = "Nie wybrano pliku";
        $(".file-upload").removeClass('active');
    }
});

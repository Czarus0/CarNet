var addParamsMake = function() {
    var url = window.location.href;
    if(url.indexOf("?") !== -1)
        url = url.substring(0,url.indexOf("?") );

    var marks = document.getElementById("carMakes");

    var newUrl = url;

    if(marks.value !== marks[0].value) {
        newUrl += '?carMake=' + marks.value;
    }

    window.location.href = newUrl;

    setDisableModels();
};

var addParamsModel = function() {
    var url = window.location.href;
    if(url.indexOf("?") !== -1)
        url = url.substring(0,url.indexOf("?") );

    var marks = document.getElementById("carMakes");
    var models = document.getElementById("carModels");

    var newUrl = url;

    if(marks.value !== marks[0].value) {
        newUrl += '?carMake=' + marks.value;

        if(models.value !== models[0].value) {
            newUrl += "&carModel=" + models.value;
        }
    }

    window.location.href = newUrl;

    setDisableModels();
};

var setDisableModels = function setDisableModels()
{
    var marks = document.getElementById("carMakes");
    var mark = marks.value;
    var models = document.getElementById("carModels");
    models.disabled = mark === "Wszystkie marki";
};

var setMakeAndModel = function () {
    var url = window.location.href;
    var mark;
    var model;
    if(url.indexOf("&") === -1) {
        mark = url.substring(url.indexOf("=") + 1, url.length );
    } else {
        mark = url.substring(url.indexOf("=") + 1, url.indexOf("&") );
        model = url.substring(url.lastIndexOf("=") + 1, url.length);

        var models = document.getElementById("carModels");

        for(i = 0; i < models.length; i++) {
            if(models[i].value === model) {
                models.selectedIndex = i;
                break;
            }
        }
    }

    var marks = document.getElementById("carMakes");

    for(i = 0; i < marks.length; i++) {
        if(marks[i].value === mark) {
            marks.selectedIndex = i;
            break;
        }
    }

    setDisableModels();
};
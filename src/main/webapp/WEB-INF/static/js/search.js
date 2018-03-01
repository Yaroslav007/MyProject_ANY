function searchValidator() {
    var fulName = document.getElementById('search');
    var filter = /^[a-zA-Z``''0-9-]+ [a-zA-Z``''0-9-]+$/;
    var button = document.getElementById("search-submit");
    if (!filter.test(fulName.value)) {
        fulName.focus;
        fulName.style.backgroundColor = "#ff6666";
         button.disabled = true;
    }else{
         fulName.style.backgroundColor = "#66cc66";
         button.disabled = false;
    }
}
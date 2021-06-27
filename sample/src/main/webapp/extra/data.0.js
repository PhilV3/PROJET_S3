function loadAPI() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET","api/user", true);

    xhr.onload = function () {
        if (this.status == 200){
            console.log(this.responseText);
            document.write(this.responseText);
        }
    }
    xhr.send();
}
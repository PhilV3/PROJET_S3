function loadAPIEtudiant() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET","api/user", true);
    xhr.onload = function () {
        if (this.status == 200){
            var cunt = this.responseText.split("'");
            var c = "<font font=\"arial\" size=\"12\" ><table border='1px'><tr><th>"+cunt[0]+"</th>";
            for (let i = 1; i < cunt.length-1; i++) {
                c += "<th>"+cunt[i]+"</th>";
            }
            c += "<th>"+cunt[cunt.length-1]+"</th></tr></table></font>";
            document.getElementById("etudiant").innerHTML = c;
            //document.write(this.responseText.split(','));
        }

    }
    xhr.send();
}
function loadAPINote() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET","api/note", true);
    xhr.onload = function () {
        if (this.status == 200){
            var cours = this.responseText.split('\n');
            var eval = cours[0].toString().substr(1).split("'");
            var c = "<font font=\"arial\" size=\"14\" ><div><table border='1px'><tr><td>"+eval[1]+"</td>";
            var res = c;
            for (let i = 0; i < cours.length-1; i++) {
                if (i != 0){
                     eval = cours[i].toString().substr(0).split("'");
                     c += "<div><table border='1px'><tr><td>"+eval[1]+"</td>";
                }
                c += "<td>"+eval[3]+"</td>";
                c += "<td>"+eval[4].substr(1,3)+"/"+eval[5].substr(1,3)+"</td>";
                c += "<td>"+eval[4].substr(5,7)+"/"+eval[5].substr(5,7)+"</td>";
                c += "<td>"+eval[4].substr(10,eval[4].length-1)+"/"+eval[5].substr(10,eval[5].length-1)+"</td></tr>";
                c += "<tr><td></td><td>"+eval[7]+"</td>";
                c += "<td>"+eval[8].substr(1,3)+"/"+eval[9].substr(1,3)+"</td>";
                c += "<td>"+eval[8].substr(5,7)+"9"+eval[9].substr(5,7)+"</td>";
                c += "<td>"+eval[8].substr(10,eval[8].length-1)+"/"+eval[9].substr(10,eval[9].length-1)+"</td></tr>";
                c += "<tr><td></td><td>"+eval[11]+"</td>";
                c += "<td>"+eval[12].substr(1,3)+"/"+eval[13].substr(1,3)+"</td>";
                c += "<td>"+eval[12].substr(5,7)+"/"+eval[13].substr(5,7)+"</td>";
                c += "<td>"+eval[12].substr(10,eval[12].length-1)+"/"+eval[13].substr(10,eval[13].length-1)+"</td></tr>";
                c += "<tr><td></td><td>"+eval[15]+"</td>";
                c += "<td>"+eval[16].substr(1,3)+"/"+eval[17].substr(1,3)+"</td>";
                c += "<td>"+eval[16].substr(5,7)+"/"+eval[17].substr(5,7)+"</td>";
                c += "<td>"+eval[16].substr(10,eval[16].length-1)+"/"+eval[17].substr(10,eval[17].length-1)+"</td></tr>";
                c += "<tr><td></td><td>"+eval[19]+"</td>";
                c += "<td>"+eval[20].substr(1,3)+"/"+eval[21].substr(1,3)+"</td>";
                c += "<td>"+eval[20].substr(5,7)+"9"+eval[21].substr(5,7)+"</td>";
                c += "<td>"+eval[20].substr(10,eval[20].length-1)+"/"+eval[21].substr(10,eval[21].length-1)+"</td></tr>";
                c += "<tr><td></td><td>"+eval[23]+"</td>";
                c += "<td>"+eval[24].substr(1,3)+"/"+eval[25].substr(1,3)+"</td>";
                c += "<td>"+eval[24].substr(5,7)+"/"+eval[25].substr(5,7)+"</td>";
                c += "<td>"+eval[24].substr(10,eval[24].length-1)+"/"+eval[25].substr(10,eval[25].length-1)+"</td></tr></table></div><br><br> ";
            }
            res += c + "</font>";
            document.getElementById("note").innerHTML = res;

          }
    }
    xhr.send();
}
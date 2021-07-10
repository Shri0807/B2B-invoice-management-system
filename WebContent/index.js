//Display Data in table
const thead = document.getElementById('thead');
const th = "<tr> <th><input type='checkbox' onclick='selectall(this)'></th> <th> Customer Name </th> <th> Customer# </th> <th> Invoice # </th> <th> Invoice Amount </th> <th> Due Date </th> <th> Predicted Payment Date </th> <th> Notes </th> </tr>";
thead.innerHTML += th;


const ShowTableonLoad = (data) => {
    
    const tableval = data;
    const tbody = document.getElementById('tbody');
    tableval.forEach(tablerow =>{
        let tablerowele = "<tr>";
    	let checkbox = "<td><input type='checkbox' class='check' onclick='highlight(this)' name='chk'></td>";
    	tablerowele += checkbox + "<td>" + tablerow['name_customer'] + "</td><td>" + tablerow['cust_number'] + "</td><td class='id'>" + tablerow['invoice_id'] + "</td><td>"+ tablerow['total_open_amount']+ "</td><td>"+ tablerow['due_in_date']+ "</td><td>"+ tablerow['predicted_clear_date'] + "</td><td class='TableNotes'>"+ tablerow['notes'] +"</td></tr>"; 
    	/*
        Object.entries(tablerow).forEach(entry => {
            const [key, value] = entry;
            tablerowele += '<td>' + value + '</td>';
            tablerowele += "</tr>";
        });*/
        
        tbody.innerHTML += tablerowele;  
    });
}

const fetchTable = () => {
    fetch('http://localhost:8080/H2HBABBA2886/fetch')
    .then(response =>{
    	return response.json()
    })
    .then(jsonresult => {
        ShowTableonLoad(jsonresult);
    })
    .catch(error => {
        console.log(error);
    })

}

//Initial Loading
(
    function() {
        fetchTable()
    }
)()

//Enable Delete if atleast 1 checkbox is checked

$("#Table1 input:checkbox").change(function(){
    $("#delbtn").prop("disabled", $("#Table1 input:checkbox:checked").length === 0);
});

//Enable Edit if 1 checkbox is checked
$("#Table1 input:checkbox").change(function(){
    $("#editbtn").prop("disabled", $("#Table1 input:checkbox:checked").length === 2);
});

//Highlight on selection
function highlight(param){
    let row = jQuery(param).parent().parent();
    row.toggleClass('highlighted');
}

//select all functionality
function selectall(param){
    checkboxes = document.getElementsByName('chk');
    for(var i=0, n=checkboxes.length;i<n;i++) {
        checkboxes[i].checked = param.checked;
        highlight(checkboxes[i]);
    }
}


//Add Invoice Modal
let addmodal = document.getElementById('addmodal');
let addbtn = document.getElementById('addbtn');
let closebtnadd = document.getElementsByClassName('closebtn')[0];
let canceladdbtn = document.getElementById('canceladdbtn');

addbtn.onclick = function(){
    addmodal.style.display = 'block';
}

closebtnadd.onclick = function(){
    addmodal.style.display = 'none';
}

window.onclick = function(event){
    if (event.target == addmodal) {
        addmodal.style.display = "none";
    }
}

canceladdbtn.onclick = function(){
    addmodal.style.display = 'none';
}

function resetadd() {
    $('#addform').trigger('reset');
}


//Edit Invoice Modal
let editmodal = document.getElementById('editmodal');
let editbtn = document.getElementById('editbtn');
let closebtnedit = document.getElementsByClassName('closebtn')[1];
let cancelbtnedit = document.getElementById('cancelbtnedit');

function resetedit(){
    $('#editform').trigger('reset');
}

editbtn.onclick = function(){
    editmodal.style.display='block';
}

closebtnedit.onclick = function(){
    editmodal.style.display = 'none';
}

window.onclick = function(event){
    if (event.target == editmodal) {
        editmodal.style.display = "none";
    }
}

cancelbtnedit.onclick = function(){
    editmodal.style.display = 'none';
}

//Del Invoice Modal
let delmodal = document.getElementById('delmodal');
let delbtn = document.getElementById('delbtn');
let closebtndel = document.getElementsByClassName('closebtn')[2];
let cancelbtndel = document.getElementById('cancelbtndel');

delbtn.onclick = function(){
    delmodal.style.display = 'block';
}

closebtndel.onclick = function () {
    delmodal.style.display = 'none';
}

window.onclick = function(event){
    if(event.target==delmodal){
        delmodal.style.display = 'none';
    }
}

cancelbtndel.onclick = function(){
    delmodal.style.display = 'none';
}


//Action for delete records
document.getElementsByClassName('deletedel')[0].onclick = function () {
	fetch('http://localhost:8080/H2HBABBA2886/del',{ method: 'POST'}).then(location.href = 'http://localhost:8080/H2HBABBA2886');
};

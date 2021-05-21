


document.addEventListener("DOMContentLoaded", domReady);

if (document.readyState === "complete" || document.readyState === "loaded") {
    console.log('loaded');
    domReady();
}



function domReady() {

    console.log("domready");






    //Create List
    {   var



    }



    //Insert, sort and delete elements
    {
        //dynamic display, based on user's choice of operation
        var insertSection= document.getElementById("InsertSection");
        var deleteSection = document.getElementById("DeleteSection");
        var sortSection = document.getElementById("SortSection");
        var modificationButton = document.getElementById("ListModificationButton");

        const selectModifierSection = function (modifierOperation) {

            console.log(modifierOperation);

            switch (modifierOperation) {
                case "Insert":
                    insertSection.style.display = "block";
                    deleteSection.style.display = "none";
                    sortSection.style.display = "none";
                    modificationButton.innerHTML = "<span></span>Insert";
                    break;
                case "Sort":
                    insertSection.style.display = "none";
                    deleteSection.style.display = "none";
                    sortSection.style.display = "block";
                    modificationButton.innerHTML = "<span></span>Sort";
                    break;
                case "Delete":
                    insertSection.style.display = "none";
                    deleteSection.style.display = "block";
                    sortSection.style.display = "none";
                    modificationButton.innerHTML = "<span></span>Delete";
                    break;
            }
        }

       //Event Listeners to modification selection radio buttons
        document.querySelectorAll('input[name="listOperation"]').forEach((radio) => {
            radio.addEventListener("change", function(event) {
              selectModifierSection(event.target.value);
            });
          });

        //display
        //document.querySelector('')


    }




    //creating list elements
    {
    const constructAjaxListCreation = function () {
        var data = {
        type: 'Integer',
        length:34
        }


        var radioInputs = document.getElementsByName('listElementType');
        for(var i = 0; i < radioInputs.length; i++) {
        if (radioInputs[i].checked) {
        if (radioInputs[i].value) {
        data.type=radioInputs[i].value;
        }
        }
        }

        const listLengthForm = document.querySelector('#ListLength');

        if (listLengthForm.value!='') {
        data.length=parseInt(listLengthForm.value);
        }


        fetch(`ListComparison/createList`,{
        method:"POST",
        body: JSON.stringify(data),
        headers: {"Content-type": "application/json; charset=UTF-8"}
        })
        .then(response => {if (!response.ok) {
        throw new Error(`Something went wrong. Status:${response.status}`);
        }
        return response.json();
        })
        .then(data => console.log(data))
        .catch(error => console.log(error.message));


        }
    const listCreationButton = document.querySelector('#ListCreationSubmitButton');
    listCreationButton.addEventListener('click',function (event) {
        event.preventDefault();
        console.log("meme");
        //console.log(constructAjaxListCreation());


    });
    }





}
























const navbarMenu = document.querySelector('.navbar__menu');
const navbarToggleBtn = document.querySelector('.navbar__toggle-btn');

navbarToggleBtn.addEventListener('click', () => {
    navbarMenu.classList.toggle('open');
});


const wordToggleBtn = document.querySelector('.word__toggle-btn');

wordToggleBtn.addEventListener('click', () => {
    getword();
});

const word1 = document.getElementById('word1');
const word2 = document.getElementById('word2');
const word3 = document.getElementById('word3');


const getword = () => {
    axios.get('https://random-word-api.herokuapp.com/word?number=3')
        .then(function (response){
            console.log(response.data);
            word1.innerText=response.data[0];
            word2.innerText=response.data[1];
            word3.innerText=response.data[2];
        })
}
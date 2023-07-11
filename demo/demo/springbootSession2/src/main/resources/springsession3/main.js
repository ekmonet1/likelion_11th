const btn = document.getElementById('btn');
const word = document.getElementById('word');

btn.addEventListener('click', () => {
    getWord();
});

const getWord = () => {
    axios.get('https://random-word-api.herokuapp.com/word')
        .then(response => {
            console.log(response); //어떤 응답이 받아와졌는지 확인
            console.log(response.data); //data만 뽑기
            word.innerText = response.data;
        })
}

const email = document.getElementById('email');
const password = document.getElementById('pw');

const Login =() => {
    axios.post('https://reqres.in/api/login',{
        email: email.value,
        password: password.value,
    }).then((res) => {
        console.log(res);
    }).catch((err) => {
        console.log(err);
    }) //post는 get과 달리 데이터 담아서 이동


}


//'https://random-word-api.herokuapp.com/word'
//'https://reqres.in/api/login'
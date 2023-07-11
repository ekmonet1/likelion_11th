const ChocoBtn = document.getElementById('ChocoBtn');
const MatchaBtn = document.getElementById('MatchaBtn');


ChocoBtn.addEventListener('mouseover',function (){
    const change_1 = document.getElementById('Chocolateimg');
    change_1.src = 'https://png.pngtree.com/element_our/20190529/ourmid/pngtree-delicious-chocolate-snack-illustration-image_1217410.jpg';

    document.addEventListener('mouseout',function (){
        change_1.src = 'https://cdn-icons-png.flaticon.com/512/119/119909.png';
    })
})

// document.getElementById('ChocoBtn').addEventListener('mouseover', function(){
//     const change_src =
//     document.getElementById('Chocolateimg').src = 'https://png.pngtree.com/element_our/20190529/ourmid/pngtree-delicious-chocolate-snack-illustration-image_1217410.jpg';
// });
// document.getElementById('ChocoBtn').addEventListener('mouseout', function(){
//     document.getElementById('Chocolateimg').src = 'https://cdn-icons-png.flaticon.com/512/119/119909.png';
// });

MatchaBtn.addEventListener('mouseover',function () {
    const change_2 = document.getElementById('Matchaimg');
    change_2.src = 'https://static01.nyt.com/images/2022/10/04/multimedia/06ASKWELL-MATCHA1/06ASKWELL-MATCHA1-superJumbo.jpg';

    document.addEventListener('mouseout', function () {
        change_2.src = 'https://cdn-icons-png.flaticon.com/512/5889/5889003.png';
    })
})

document.getElementById('GardenBtn').addEventListener('click', function(){
    document.getElementById('Gardenimg').src = 'https://hips.hearstapps.com/hmg-prod/images/claude-monets-house-and-gardens-in-giverny-france-news-photo-1042013294-1562610151.jpg?crop=1.00xw:0.753xh;0,0.0671xh&resize=1200:*';
});

document.getElementById('PianoBtn').addEventListener('click', function(){
    document.getElementById('Pianoimg').src = 'https://www.yamaha.com/en/musical_instrument_guide/common/images/piano/parts_viewer01.jpg';
});

document.getElementById('YoutubeBtn').addEventListener('click', function(){
    document.getElementById('Youtubeimg').src = 'https://www.youtube.com/img/desktop/yt_1200.png';
});

document.getElementById('BeachBtn').addEventListener('click', function(){
    document.getElementById('Beachimg').src = 'https://img.freepik.com/free-photo/tropical-beach_74190-188.jpg?w=2000';
});

document.getElementById('CatBtn').addEventListener('click', function(){
    document.getElementById('Catimg').src = 'https://hips.hearstapps.com/hmg-prod/images/domestic-cat-lies-in-a-basket-with-a-knitted-royalty-free-image-1592337336.jpg?crop=0.668xw:1.00xh;0.247xw,0&resize=1200:*';
});

document.getElementById('TravelBtn').addEventListener('click', function(){
    document.getElementById('Travelimg').src = 'https://media.istockphoto.com/id/1285301614/photo/young-man-arms-outstretched-by-the-sea-at-sunrise-enjoying-freedom-and-life-people-travel.jpg?s=612x612&w=0&k=20&c=0QW6GnkuFNYcPZhy26XVHuTc2avJTK8u6l_1iT0SlZk=';
});

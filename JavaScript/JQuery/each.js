let array = [
    { name : 'Hanbit Media', link : 'http://hanb.co.kr'},
    { name : 'Naver', link : 'http://naver.com'},
    { name : 'Daum', link : 'http://daum.net'},
    { name : 'Paran', link : 'http://paran.com'}        ];

    $.each(array, function (index, item) {
        let output = '';
        output += '<a href = "' + item.link + '">';
        output += ' <h1 >' + item.name + '</h1>';
        output += ' </a>';
        document.body.innerHTML += output;
    });
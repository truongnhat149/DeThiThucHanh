function runPTBN() {
    let a = document.getElementById('number_1').value;
    let b = document.getElementById('number_2').value;
    if (a != 0) {
        alert(`Phuong trinh co nghiem ${-b/a}`)
    } else if (a == 0) {
        alert(`Phuong trinh vo nghiem`)
    }
}

function findIndex() {
    let index = Number(document.querySelector('#indexRandom').value);
    let arr = [0, 1, 4, 3, 2, 10, 33, 6, 5, 9, 11];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] == index) {
            alert(`Số vừa nhập có trong mảng,nằm ở vị trí: ${arr.indexOf(index)}`);
        }
    }
    return -1;
}

let a = ['codegymHue'];
// let randomString = document.getElementById('randomString').value;
function findInteger(a) {
    let string = ['a', 'o', 'e', 'u', 'i']
    let arr = [];
    arr = a.split("");
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < string.length; j++)
            if (arr[i] === string[j]) {
                return true;
            }
    }
    return false;
}
document.getElementById('showResult').innerHTML = findInteger('123abc');
let detail = JSON.parse(localStorage.getItem('detail'))
console.log(detail[0].image);
document.getElementById('main-img').src = detail[0].image.slice(1, -1);
document.getElementById('main-title').innerHTML = detail[0].title;
document.getElementById('main-price').innerHTML = `<del>${(parseInt(detail[0].price) + (parseInt(detail[0].price) * 0.2))}.00$</del> ${detail[0].price}`;
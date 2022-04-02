
function Animal(name, weight) {
        this.name = name;
        this.weight = weight;
        this.toString = function() {
            return `tên của con vật là :${this.name}, cân nặng của nó là ${this.weight}`
        }
        this.setName = function (name) {
            this.name = name;
        }
        this.setWeight = function (weight) {
            this.weight = weight;
        }
        this.getName = function() {
            return this.name;
        }
        this.getWeight = function() {
            return this.weight;
        }
    }
    
let objAnimal1 = new Animal('Elephant',45.6);
console.log(objAnimal1.toString())

let objAnimal2 = new Animal('Tiger',30)
objAnimal2.setName('mouse')
console.log(objAnimal2.name)

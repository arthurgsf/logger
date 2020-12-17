import ApiService from './ApiService'

class MaquinaService extends ApiService {
    constructor () {
        super('/api/maquina')
    }
}
export default MaquinaService
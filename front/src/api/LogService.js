import ApiService from './ApiService'

class LogService extends ApiService {
    constructor () {
        super('/api/log')
    }
}
export default LogService
import { FC } from "react"

const URL= 'http://localhost:8080/realms/nott-test-oidc/protocol/openid-connect/auth'
const clientId = 'nott';
const redirectUrl = 'http://localhost:3000/page1'

export const Login: FC<{}> = () => {
    return <button onClick={() => {
        console.log('login clicked')
        window.location.replace(`${URL}?client_id=${clientId}&redirect_uri=${encodeURI(redirectUrl)}&scope=openid&response_type=code&response_mode=query`)
    }}>Login</button>
}

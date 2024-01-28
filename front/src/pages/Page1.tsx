import axios from "axios";
import { FC, useEffect, useState } from "react"
import { useSearchParams } from "react-router-dom";
import { CopyBlock } from "react-code-blocks";

export const Page1: FC<{}> = () => {
    const [searchParams, setSearchParams] = useSearchParams();
    const [token, setToken] = useState<any>(undefined)
    const code = searchParams.get('code');
    useEffect(() => {
        const getToken = async () => {
            if (code) {
                const response = await axios.post('http://localhost:8081/auth/token', {
                    code: code,
                    redirectUrl: 'http://localhost:3000/page1'
                })
                setToken(response.data)
            }
            
        }
        getToken();
    }, [])
    


    return <div>
        <CopyBlock
            text={JSON.stringify(token, null, 2)}
            language={'json'}
         /></div>
}
import { Button, Form } from "react-bootstrap"
import Icon from "../assets/Icon.png"

export function Login() {
    return (
        <div>
            <div>
                <div>
                    <img src={Icon} alt="Icono" width={"60px"} />
                </div>
                <h1>Moneta</h1>
                <h3>Sing up Account</h3>
            </div>

            <Form>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter email" />
                </Form.Group>

                <Form.Group className="mb-3" controlId="formBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" placeholder="Password" />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>

            <p>Don't have an account? <a href="#">Register</a></p>
        </div>
    )
}
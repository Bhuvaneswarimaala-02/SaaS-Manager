import { Link } from "react-router-dom";

const Home = () => {
    return (
        <div>
            <h1>Welcome to Subscription Manager</h1>
            <Link to="/login">Login</Link> | <Link to="/signup">Signup</Link>
        </div>
    );
};

export default Home;

import { useEffect, useState } from "react";
import { fetchSubscriptions } from "../services/api";

const SubscriptionList = () => {
    const [subscriptions, setSubscriptions] = useState([]);

//     useEffect(() => {
//         fetchSubscriptions().then((response) => {
//             setSubscriptions(response.data);
//         }).catch((error) => {
//             console.error("Error fetching subscriptions:", error);
//         });
//     }, []);

    useEffect(() => {
        fetch("http://localhost:8080/subscriptions/all")
            .then(response => response.json())
            .then(data => {
                console.log("📌 Data received:", data); // Debugging step
                setSubscriptions(data);
            })
            .catch(error => console.error("❌ Fetch error:", error));
    }, []);


    return (
        <div>
            <h2>Subscriptions</h2>
            <ul>
                {subscriptions.map(sub => (
                    <li key={sub.id}>{sub.name} - ${sub.price}</li>
                ))}
            </ul>
        </div>
    );
};

export default SubscriptionList;
